<%@page import="com.mycompany.models.Usuario"%>
<%
    Usuario user_registrado = (Usuario)request.getSession().getAttribute("usuario_registrado");
%>
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>VLab</title>
        <meta name="description" content="Ela Admin - HTML5 Admin Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="images/logo_unmsm.png">
        <link rel="shortcut icon" href="images/logo_unmsm.png">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

    </head>
    <body>
        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="menu-title">Usuarios</li><!-- /.menu-title -->
                        <li>
                            <a href="/ProyectoPatrones/controlador_lista_usuarios"><i class="menu-icon fa fa-user"></i>Lista de usuarios</a>
                        </li>
                        <li>
                            <a href="/ProyectoPatrones/controlador_crear_usuario"><i class="menu-icon fa fa-user-plus"></i>Crear usuario</a>
                        </li>

                        <li class="menu-title">Cursos</li><!-- /.menu-title -->
                        <li>
                            <a href="/ProyectoPatrones/controlador_lista_cursos"><i class="menu-icon fa fa-folder"></i>Lista de cursos</a>
                        </li>
                        <li  class="active">
                            <a href="/ProyectoPatrones/controlador_crear_curso"><i class="menu-icon fa fa-plus-square"></i>Crear curso</a>
                        </li>
                        <li class="menu-title">Simuladores</li><!-- /.menu-title -->
                        <li>
                            <a href="/ProyectoPatrones/controlador_lista_simuladores"><i class="menu-icon fa fa-briefcase"></i>Lista de simuladores</a>
                        </li>
                        <li>
                            <a href="/ProyectoPatrones/controlador_crear_simulador"><i class="menu-icon fa fa-plus-square-o"></i>Crear simulador</a>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel">

                        <!-- Header-->
            <header id="header" class="header">
                <div class="top-left">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="./"><img src="images/logo.svg" alt="Logo"></a>
                        <a class="navbar-brand hidden" href="./"><img src="images/logo.svg" alt="Logo"></a>
                        <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                    </div>
                </div>
                <div class="top-right">
                    <div class="header-menu">
                        <div class="header-left">
                          
                            <div class="dropdown for-notification">
                                <button class="btn btn-secondary dropdown-toggle" type="button" id="notification" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class=""><%=user_registrado.getFirstname() %> <%=user_registrado.getLastname() %></i>
                                </button>
                                
                            </div>

                        </div>

                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle active" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img class="user-avatar rounded-circle" src="images/icon_user.png" alt="User Avatar">
                            </a>
                               
                            <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="/ProyectoPatrones/controlador_exit"><i class="fa fa-power-off"></i>Salir</a>
                            </div>
                        </div>
                    </div>
                </div>
            </header><!-- /header -->
            <!-- Header-->

            <div class="breadcrumbs">
                <div class="breadcrumbs-inner">
                    <div class="row m-0">
                        <div class="col-sm-4">
                            <div class="page-header float-left">
                                <div class="page-title">
                                    <h1>Crear curso</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="page-header float-right">
                                <div class="page-title">
                                    <ol class="breadcrumb text-right">
                                        <li><a href="#">Curso</a></li>
                                        <li class="active">Crear curso</li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="content">
                <div class="animated fadeIn">
                    <form action="/ProyectoPatrones/controlador_crear_curso" method="post">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header"><strong>Agregar curso</strong><small> </small></div>
                                    <div class="card-body card-block">
                                        <div class="form-group"><label for="nombre" class=" form-control-label">Nombre del curso</label><input type="text" id="nombre" name="nombre" placeholder="Ingrese nombre del curso" class="form-control" required></div>
                                    </div>
                                    <div class="form-actions form-group right-panel"><button type="submit" class="btn btn-success btn-lg">Crear curso</button></div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="clearfix"></div>

            <footer class="site-footer">
                <div class="footer-inner bg-white">
                    <div class="row">
                        <div class="col-sm-6">
                            Copyright &copy; 2021 VLab
                        </div>
                        <div class="col-sm-6 text-right">
                            Designed by <a href="#">Jhonathan Centti</a>
                        </div>
                    </div>
                </div>
            </footer>

        </div><!-- /#right-panel -->

        <!-- Right Panel -->

        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="assets/js/main.js"></script>


    </body>
</html>
