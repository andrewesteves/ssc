<%@ include file="/header.jsp" %>
<div class="row">
    <div class="col-8 mx-auto">
        <h1 class="text-center">Informe suas credenciais</h1>
        <div class="card">
            <div class="card-header"><i class="fa fa-lock"></i> Acessar</div>
            <div class="card-body">
                <% if(request.getParameter("success") != null) { %>
                <div class="alert alert-success">Dados autenticados com sucesso.</div>
                <% } %>
                <% if(request.getParameter("error") != null) { %>
                <div class="alert alert-danger">Os dados não conferem com nossos registros, por favor tente novamente.</div>
                <% } %>
                <form method="post" action="http://localhost:8080/SSC_WEB/Login">
                    <div class="form-group">
                        <label>E-mail:</label>
                        <input type="text" name="email" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Senha:</label>
                        <input type="password" name="senha" class="form-control">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">
                            <i class="fa fa-sign-in"></i> Logar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>