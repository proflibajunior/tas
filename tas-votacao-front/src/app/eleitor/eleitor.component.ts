import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSidenav } from '@angular/material/sidenav';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConfirmDialogComponent } from '../_components/confirm-dialog/confirm-dialog.component';
import { SecaoEntity, SecaoService } from '../_services/secao.service';
import { EleitorEntity, EleitorService } from '../_services/eleitor.service';

@Component({
  selector: 'app-eleitor',
  templateUrl: './eleitor.component.html',
  styleUrls: ['./eleitor.component.scss']
})
export class EleitorComponent implements OnInit {

  public displayedColumns: string[] = ['codigo','nome','titulo','email', 'endereco', 'zona', 'secao', 'ativo', 'options'];

  public secoes: SecaoEntity[] = [];
  public eleitores: EleitorEntity[] = [];
  public eleitor: EleitorEntity = new EleitorEntity();

  //Variaveis de controle
  public loading: boolean;
  public errorMessage: string;

  @ViewChild(MatSidenav, { static: true }) sidenav: MatSidenav;

  constructor(private service: EleitorService, private secaoService: SecaoService, private snakBar: MatSnackBar,
    private dialog: MatDialog) { }

  /**
   * Método disparado na inicialização do componente, logo após sua construção 
   */
  ngOnInit(): void {
    //Inicia as variáveis
    this.errorMessage = '';
    this.loading = true;

    //Carrega todos os registros
    this.service.listar().subscribe(result => {

      //Carrega os secoes
      this.secaoService.listar().subscribe(result => {
        this.secoes = result as [];
      });

      //Alimenta o datasource da tabela com os registros recebidos da service
      this.eleitores = result as [];

    }, error => {

      //Se ocorreu algum erro neste processo, mostra mensagem para usuário
      this.showError('Ops! Alconteceu algo...', error);

    }).add(() => {

      //Após a execução do subscribe, dando erro ou não, oculta a barra de progresso
      this.loading = false;

    })
  }

  /**
   * Dá um open na sidnav exibindo o formulário com os dados 
   * da objeto passado por parâmetro.
   * 
   * @param eleitor 
   */
  private openSidenav(eleitor: EleitorEntity): void {
    this.eleitor = eleitor;
    this.sidenav.open();
  }

  /**
   * Função responsável por mostrar uma mensagem de erro padrão.
   * @param text
   * @param error 
   */
  private showError(text: string, error: any): void {
    //Mostra a snackbar com fundo customizado (vermelho)
    this.snakBar.open(text, '', {
      duration: 5000,
      panelClass: 'snackWarn'
    });

    //Adiciona a mensagem de erro no painel de erro
    this.errorMessage = (error.status == 0) ? 'Não foi possível conectar ao servidor' : error.message;
  }

  /**
   * Abre o formulário com um novo cliente para inclusão
   */
  public adicionar(): void {
    this.openSidenav(new EleitorEntity());
  }

  /**
   * Abre o formulário com os campos preenchidos com os valores
   * do parametro.
   * 
   * @param eleitor
   */
  public editar(eleitor: EleitorEntity): void {
    this.openSidenav(Object.assign({}, eleitor));
  }

  /**
   * Chama a janela de confirmação de exclusão, se usuário confirmar
   * chama evento de exclusão da service.
   * 
   * @param eleitor 
   */
  public excluir(eleitor: EleitorEntity): void {
    //Mostra a janela modal de confirmação
    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: '400px'
    });

    //Depois de fechado (clicado em cancelar ou confirmar)...
    dialogRef.afterClosed().subscribe(result => {
      
      //Se confirmou, exclui o registro
      if (result) {
        this.loading = true;

        this.service.excluir(eleitor.id).subscribe(result => {

          //Deu certo, avisa o usuário...
          this.snakBar.open('Registro excluído com sucesso!', '', {
            duration: 3500
          });

          //Atualiza a lista (Ok, esta não é a forma mais inteligente de fazer isto...)
          this.ngOnInit();

        }, error => {

          //Se ocorreu algum erro neste processo, mostra mensagem para usuário
          this.showError('Não foi possível exluir o registro', error);

        }).add(() => {
          
          //Após a execução do subscribe, dando erro ou não, oculta a barra de progresso
          this.loading = false;

        });
      }
    })
  }

  /**
   * Método chamado ao confirmar uma inclusão/alteração
   */
  public confirmar(): void {
    //Mostra a barra de progresso
    this.loading = true;

    //Chama o método salvar (incluir ou alterar) da service
    this.service.salvar(this.eleitor).subscribe(result => {

      //Deu tudo certo, então avise o usuário...
      this.snakBar.open('Registro salvo com sucesso!', '', {
        duration: 3500
      });

      //Atualiza a lista (Ok, esta não é a forma mais inteligente de fazer isto...)
      this.ngOnInit();

    }, error => {

      //Se ocorreu algum erro neste processo, mostra mensagem para usuário
      this.showError('Não foi possível salvar o registro', error);

    }).add(() => {

      //Após a execução do subscribe, dando erro ou não, 
      //oculta a barra de progresso...
      this.loading = false;

      //... e fecha a sidenav com o formulário
      this.sidenav.close();
    });
  }

  /**
   * Funçao responsavel por carregar um item no select, comparando
   * os dois parametros se possuem ID's identicos.
   * 
   * @param item1 
   * @param item2 
   */
  public compareOptions(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }

}
