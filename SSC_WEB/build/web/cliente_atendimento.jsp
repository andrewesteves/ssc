<%@page import="java.util.List"%>
<%@page import="ssc.modelos.basicas.Atendimento"%>
<%@ include file="/header.jsp" %>
<div class="col-12">
    <div class="card">
        <div class="card-header bg-warning">
            <h1 class="card-title float-left">Atendimentos</h1> 
            <span class="float-right">
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#abrirAtendimento">
                    <i class="fa fa-commenting-o"></i> Abrir chamado
                </button>
                <a href="http://localhost:8080/SSC_WEB/Login?acao=logout" class="btn btn-secondary btn-lg">
                   <i class="fa fa-sign-out"></i> Sair
                </a>
            </span>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("success") != null) { %>
            <div class="alert alert-success">Mensagem enviada com sucesso.</div>
            <% } %>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Assunto</th>
                        <th>Descrição</th>
                        <th>Situação</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Atendimento> atendimentos = (List<Atendimento>) request.getAttribute("atendimentos"); %>
                    <% for(Atendimento atendimento: atendimentos) { %>
                    <tr>
                        <td><%= atendimento.getAssunto() %></td>
                        <td><%= atendimento.getDescricao() %></td>
                        <td><%= atendimento.getSituacao() %></td>
                        <td>
                            <a href="http://localhost:8080/SSC_WEB/ClienteMensagem?id_atendimento=<%= atendimento.getId() %>" class="btn btn-secondary"><i class="fa fa-reply"></i></a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" tabindex="-1" role="dialog" id="abrirAtendimento">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Iniciar atendimento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="http://localhost:8080/SSC_WEB/ClienteAtendimento" method="post" id="formulario">
                    <input type="hidden" name="acao" value="criar">
                    <div class="form-group">
                        <label for="">Assunto</label>
                        <input type="text" name="assunto" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="">Descrição</label>
                        <textarea name="descricao" id="" cols="30" rows="10" class="form-control"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="submit" form="formulario" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>