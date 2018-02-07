<%@page import="java.util.List"%>
<%@page import="ssc.modelos.basicas.Atendimento"%>
<%@page import="ssc.modelos.basicas.Mensagem"%>
<%@ include file="/header.jsp" %>
<% Atendimento atendimento = (Atendimento) request.getAttribute("atendimento"); %>
<% List<Mensagem> mensagens = atendimento.getMensagens(); %>
<div class="col-12">
    <div class="card">
        <div class="card-header bg-warning">
            <h1 class="card-title float-left">Atendimento: <%= atendimento.getAssunto() %></h1>
            <span class="float-right">
                <a href="http://localhost:8080/SSC_WEB/ClienteAtendimento" class="btn btn-primary btn-lg">
                   <i class="fa fa-arrow-circle-o-left"></i> Voltar
                </a>
                <a href="http://localhost:8080/SSC_WEB/Login?acao=logout" class="btn btn-secondary btn-lg">
                   <i class="fa fa-sign-out"></i> Sair
                </a>
            </span>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("success") != null) { %>
            <div class="alert alert-success">Mensagem enviada com sucesso.</div>
            <% } %>
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="card-title">Responder</h2>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/ClienteMensagem?id_atendimento=<%= atendimento.getId() %>" method="post">
                                <input type="hidden" name="acao" value="criar">
                                <div class="form-group">
                                    <label for="">Mensagem</label>
                                    <textarea name="descricao" required id="" cols="30" rows="10" class="form-control"></textarea>
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fa fa-save"></i> Salvar
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div><hr>
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>Mensagens</th>
                        <th>Usuário</th>
                    </tr>
                </thead>
                <tbody>                    
                    <% for(Mensagem mensagem : mensagens) { %>
                    <tr>
                        <td><%= mensagem.getDescricao() %></td>
                        <td><%= mensagem.getUsuario().getNome() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>