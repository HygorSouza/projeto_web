		<!-- Modal -->
        <div class="modal fade" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
             <div class="modal-dialog" role="document">
                 <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                           </button>
                           <h4 class="modal-title" id="modalLabel">Excluir Cliente</h4>
                    </div>
                    <div class="modal-body">
                        Deseja realmente excluir este cliente?
                    </div>
                    <div class="modal-footer">
                    	<form action="servletController.do" method="post">
                        	<input type="hidden" name="id" id="id_excluir" />
                            <button name="command" id="btn_excluir" type="submit" class="btn btn-primary" value="ExcluirCliente" >Sim</button>
                            <button  type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                    	</form>
                    </div>
                  </div>
              </div>
         </div>
         <!-- /.modal -->