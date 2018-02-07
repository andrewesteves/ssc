<%@page import="java.util.List"%>
<%@page import="ssc.modelos.basicas.Atendimento"%>
<%@page import="ssc.modelos.basicas.Mensagem"%>
<%@ include file="/header.jsp" %>
<%@ include file="/nav.jsp" %>
<% Atendimento atendimento = (Atendimento) request.getAttribute("atendimento"); %>
<% List<Mensagem> mensagens = atendimento.getMensagens(); %>
<div class="col-12">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h1 class="card-title">Atendimento: <%= atendimento.getAssunto() %></h1>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("success") != null || request.getParameter("success") != null) { %>
            <div class="alert alert-success">Operação realizada com sucesso.</div>
            <% } %>
            <div class="row">
                <div class="col-12">
                    <div class="card text-white bg-dark">
                        <div class="card-header">
                            <h4 class="card-title">Situação</h4>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/AdminAtendimento" method="post">
                                <input type="hidden" name="acao" value="atualizar">
                                <input type="hidden" name="id_atendimento" value="<%= atendimento.getId() %>">
                                <div class="form-row">
                                    <div class="col">
                                        <select name="situacao" id="" class="form-control">
                                            <option value="<%= atendimento.getSituacao() %>"><%= atendimento.getSituacao() %></option>
                                            <option value="Aberto">Aberto</option>
                                            <option value="Aguardando">Aguardando</option>
                                            <option value="Fechado">Fechado</option>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <button type="submit" class="btn btn-warning form-control">
                                            <i class="fa fa-save"></i> Atualizar
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div><br>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="card-title">Responder</h2>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/AdminMensagem?id_atendimento=<%= atendimento.getId() %>" method="post">
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