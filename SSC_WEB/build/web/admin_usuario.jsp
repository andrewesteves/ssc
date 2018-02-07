<%@page import="ssc.modelos.basicas.Acesso"%>
<%@page import="java.util.List"%>
<%@page import="ssc.modelos.basicas.Usuario"%>
<%@ include file="/header.jsp" %>
<%@ include file="/nav.jsp" %>
<% List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios"); %>
<div class="col-12">
    <div class="card">
        <div class="card-header bg-primary text-white">
            <h1 class="card-title">Usuarios</h1>
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
                            <% for(Usuario usuario : usuarios) { %>
                            <tr>
                                <td><%= usuario.getNome() %></td>
                                <td>
                                    <%= usuario.getAcesso() %>
                                </td>
                                <td>
                                    <a href="http://localhost:8080/SSC_WEB/AdminUsuario?acao=editar&id_usuario=<%= usuario.getId() %>" class="btn btn-warning">
                                        <i class="fa fa-pencil"></i>
                                    </a>
                                    <a href="http://localhost:8080/SSC_WEB/AdminUsuario?acao=remover&id_usuario=<%= usuario.getId() %>" class="btn btn-danger">
                                        <i class="fa fa-trash"></i>
                                    </a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <% if(request.getAttribute("usuarioEditar") == null) { %>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="card-title">Novo</h2>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/AdminUsuario" method="post">
                                <input type="hidden" name="acao" value="criar">
                                <div class="form-group">
                                    <label for="">Nome</label>
                                    <input type="text" name="nome" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">E-mail</label>
                                    <input type="email" name="email" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">Acesso</label>
                                    <select name="acesso" id="" class="form-control">
                                        <option value="1">Cliente</option>
                                        <option value="0">Administrador</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="">Senha</label>
                                    <input type="password" name="senha" required class="form-control">
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
                <% Usuario u = (Usuario) request.getAttribute("usuarioEditar"); %>
                <div class="col-4">
                    <div class="card">
                        <div class="card-header">
                            <h2 class="card-title">Editar</h2>
                        </div>
                        <div class="card-body">
                            <form action="http://localhost:8080/SSC_WEB/AdminUsuario" method="post">
                                <input type="hidden" name="acao" value="atualizar">
                                <input type="hidden" name="id_usuario" value="<%= u.getId() %>">
                                <div class="form-group">
                                    <label for="">Nome</label>
                                    <input type="text" name="nome" value="<%= u.getNome() %>" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">E-mail</label>
                                    <input type="email" name="email" value="<%= u.getEmail() %>" required class="form-control">
                                </div>
                                <div class="form-group">
                                    <label for="">Acesso</label>
                                    <select name="acesso" id="" class="form-control">
                                        <option value="1" <%= u.getAcesso() == Acesso.CLIENTE ? "selected" : "" %>>Cliente</option>
                                        <option value="0" <%= u.getAcesso() == Acesso.ADMIN ? "selected" : "" %>>Administrador</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="">Senha</label>
                                    <input type="password" name="senha" value="<%= u.getSenha() %>" required class="form-control">
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