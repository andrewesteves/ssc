<%@page import="ssc.modelos.basicas.Servico"%>
<%@page import="java.util.List"%>
<%@ include file="/header.jsp" %>
<%@ include file="/nav.jsp" %>
<% List<Servico> servicos = (List<Servico>) request.getAttribute("servicos"); %>
<div class="col-12">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h1 class="card-title">Serviços</h1>
        </div>
        <div class="card-body">
            <% if(request.getAttribute("success") != null) { %>
            <div class="alert alert-success"><%= request.getAttribute("success") %></div>
            <% } %>
            <div class="row">
                <div class="col-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Usuários</th>
                                <th>Acesso</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>                    
                            <% for(Servico servico : servicos) { %>
                            <tr>
                                <td><%= servico.getTitulo() %></td>
                                <td>
                                    <%= servico.getDescricao() %>
                                </td>
                                <td>
                                    <a href="http://localhost:8080/SSC_WEB/AdminServico?acao=editar&id_servico=<%= servico.getId() %>" class="btn btn-warning">
                                        <i class="fa fa-pencil"></i>
                                    </a>
                                    <a href="http://localhost:8080/SSC_WEB/AdminServico?acao=remover&id_servico=<%= servico.getId() %>" class="btn btn-danger">
                                        <i class="fa fa-trash"></i>
                                    </a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <% if(request.getAttribute("servicoEditar") == null) { %>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="card-title">Novo</h2>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/AdminServico" method="post">
                                <input type="hidden" name="acao" value="criar">
                                <div class="form-group">
                                    <label for="">Título</label>
                                    <input type="text" name="titulo" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">Descrição</label>
                                    <textarea name="descricao" id="" cols="30" rows="10" class="form-control" required></textarea>
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
                <% }else { %>
                <% Servico s = (Servico) request.getAttribute("servicoEditar"); %>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="card-title">Editar</h2>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/AdminServico" method="post">
                                <input type="hidden" name="acao" value="atualizar">
                                <input type="hidden" name="id_servico" value="<%= s.getId() %>">
                                <div class="form-group">
                                    <label for="">Título</label>
                                    <input type="text" name="titulo" value="<%= s.getTitulo() %>" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">Descrição</label>
                                    <textarea name="descricao" id="" cols="30" rows="10" class="form-control" required><%= s.getDescricao() %></textarea>
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
                <% } %>
            </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>