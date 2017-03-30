<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div class="container">
    <h1>LOGO</h1>

</div>
<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">

            <ul class="nav navbar-nav">
                <li><a href="StronaGlowna.html">Strona główna</a></li>
                <li><a href="DokonajRezerwacji.html">Dokonaj rezerwacji</a></li>
                <li><a href="#">Cennik</a></li>
                <li><a href="Kontakt.html">Kontakt</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle"  href="#">Dojazd
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Parking 1</a></li>
                        <li><a href="#">Parking 2</a></li>
                        <li><a href="#">Parking 3</a></li>
                    </ul>

                <li class="dropdown">
                    <a class="dropdown-toggle" href="#">Mój profil
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Moje dane</a></li>
                        <li><a href="#">Moje rezerwacje</a></li>
                        <li><a href="#">Zmień hasło</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Załóż konto</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Zaloguj się</a></li>
            </ul>
        </div>
    </nav>
</div>
<div class="container">
    <form method="post" action="https://secure.payu.com/api/v2_1/orders">
        <input type="hidden" name="continueUrl" value="http://shop.url/continue">
        <input type="hidden" name="currencyCode" value="PLN">
        <input type="hidden" name="customerIp" value="123.123.123.123">
        <input type="hidden" name="description" value="Order description">
        <input type="hidden" name="merchantPosId" value="145227">
        <input type="hidden" name="notifyUrl" value="http://shop.url/notify">
        <input type="hidden" name="products[0].name" value="Miejsce 1">
        <input type="hidden" name="products[0].quantity" value="1">
        <input type="hidden" name="products[0].unitPrice" value="1000">
        <input type="hidden" name="totalAmount" value="1000">
        <input type="hidden" name="OpenPayu-Signature" value="sender=145227;algorithm=SHA-256;signature=bc94a8026d6032b5e216be112a5fb7544e66e23e68d44b4283ff495bdb3983a8">
        <button type="submit" formtarget="_blank" >Pay with PayU</button>
    </form >

</div>