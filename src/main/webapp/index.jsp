<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/uikit@3.19.4/dist/css/uikit.min.css" />
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
         <link rel="stylesheet" href="css/login.css">
</head>
<body>
   <section class="vh-100 gradient-custom">
         <div class="container py-5 h-100">
           <div class="row d-flex justify-content-center align-items-center h-100">
             <div class="col-12 col-md-8 col-lg-6 col-xl-5">
               <div class="card bg-dark text-white" style="border-radius: 1rem;">
                 <div class="card-body p-5 text-center">
                   <div class="mb-md-5 mt-md-4 pb-5">
                     <h2 class="fw-bold mb-2 text-uppercase">Registration</h2>
                     <p class="text-white-50 mb-5">Please enter your login and password!</p>
                   <form class="form" method="post">
                      <div data-mdb-input-init class="form-outline form-white mb-4">
                       <input type="text" id="typeFirstName" class="form-control form-control-lg firstName" name ="firstName" />
                       <label class="form-label" for="typeFirstName">firstName</label>
                       </div>
                       <div data-mdb-input-init class="form-outline form-white mb-4">
                       <input type="text" id="typeLastName" class="form-control form-control-lg lastName" name ="lastName" />
                       <label class="form-label" for="typeFirstName">firstName</label>
                       </div>
                     <div data-mdb-input-init class="form-outline form-white mb-4">
                       <input type="email" id="typeEmailX" class="form-control form-control-lg email" name ="email" />
                       <label class="form-label" for="typeEmailX">Email</label>
                     </div>
                     <div data-mdb-input-init class="form-outline form-white mb-4">
                       <input type="password" id="typePasswordX" class="form-control form-control-lg password" name="password" />
                       <label class="form-label" for="typePasswordX">Password</label>
                     </div>
                     <button data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-light btn-lg px-5 " onclick="ready()" type="submit">Sign Up</button>
                     </form>
                     <div class="d-flex justify-content-center text-center mt-4 pt-1">
                       <a href="#!" class="text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                       <a href="#!" class="text-white"><i class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                       <a href="#!" class="text-white"><i class="fab fa-google fa-lg"></i></a>
                     </div>
                   </form>
                   <div>
                     <p class="mb-0">Already have an account? <a href="login" class="text-white-50 fw-bold">Login</a>
                     </p>
                   </div>
                 </div>
               </div>
             </div>
           </div>
         </div>
       </section>


 <jsp:include page="footer.jsp"></jsp:include>
    <script src="js/registration.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.19.4/js/uikit-icons.min.js"></script>
</body>
</html>