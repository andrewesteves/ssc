<%@page import="java.util.List"%>
<%@page import="ssc.modelos.basicas.Atendimento"%>
<%@ include file="/header.jsp" %>
<%@ include file="/nav.jsp" %>
<div class="col-12">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h1 class="card-title">Atendimentos</h1>
        </div>
        <div class="card-body">
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
                            <a href="http://localhost:8080/SSC_WEB/AdminMensagem?id_atendimento=<%= atendimento.getId() %>" class="btn btn-secondary"><i class="fa fa-reply"></i></a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>