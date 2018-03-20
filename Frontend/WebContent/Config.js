var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function ($routeProvider)
{
console.log("I am in Route Provider");
$routeProvider.when("#/",{templateUrl:"index.jsp"})
	.when("/Registration",{templateUrl:"view/Registration.html"})
	.when("/Login",{templateUrl:"view/Login.html"})
	.when("/About",{templateUrl:"view/About.html"})
	.when("/Contact",{templateUrl:"view/Contact.html"});
});