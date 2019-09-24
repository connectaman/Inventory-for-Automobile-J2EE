<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Us</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="libs/css/contact.css">
</head>
<body>
<jsp:include page="WEB-INF/views/header.jsp"></jsp:include>
  <div class="container">
    <div class="innerwrap">

      <section class="section1 clearfix">
        <div class="textcenter">
          <span class="shtext">Contact Us</span>
          <span class="seperator"></span>
          <h1>Drop Us a Mail</h1>
        </div>
      </section>

      <section class="section2 clearfix">
        <div class="col2 column1 first">
          <script src='https://maps.googleapis.com/maps/api/js?v=3.exp'></script>
          <div class="sec2map" style='overflow:hidden;height:550px;width:100%;'>
            <div id='gmap_canvas' style='height:100%;width:100%;'></div>
            <div><small><a href="http://embedgooglemaps.com">									embed google maps							</a></small></div>
            <div><small><a href="http://freedirectorysubmissionsites.com/">free web directories</a></small></div>
            <style>
              #gmap_canvas img {
                max-width: none !important;
                background: none !important
              }
            </style>
          </div>
          <script type='text/javascript'>
            function init_map() {
              var myOptions = {
                zoom: 14,
                center: new google.maps.LatLng(19.075314480255834, 72.88153973865361),
                mapTypeId: google.maps.MapTypeId.ROADMAP
              };
              map = new google.maps.Map(document.getElementById('gmap_canvas'), myOptions);
              marker = new google.maps.Marker({
                map: map,
                position: new google.maps.LatLng(19.075314480255834, 72.88153973865361)
              });
              infowindow = new google.maps.InfoWindow({
                content: '<strong>My Location</strong><br>Bangalore<br>'
              });
              google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map, marker);
              });
              infowindow.open(map, marker);
            }
            google.maps.event.addDomListener(window, 'load', init_map);
          </script>
        </div>
        <div class="col2 column2 last">
          <div class="sec2innercont">
            <div class="sec2addr">
              <p>232,Bangalore Karnataka </p>
              <p><span class="collig">Phone :</span> +91 9723212083</p>
              <p><span class="collig">Email :</span> hello@hello.com</p>
              <p><span class="collig">Fax :</span> +91 9753230839</p>
            </div>
          </div>
          <div class="sec2contactform">
            <h3 class="sec2frmtitle">Want to Know More?? Drop Us a Mail</h3>
            <form action="ContactMail" method="POST">
              <div class="clearfix">
                <input class="col2 first" type="text" name="fname"  placeholder="FirstName">
                <input class="col2 last" type="text" name="lname" placeholder="LastName">
              </div>
              <div class="clearfix">
                <input class="col2 first" type="email" name="mail" placeholder="Email">
                <input class="col2 last" type="text" name="phone" placeholder="Contact Number">
              </div>
              <div class="clearfix">
                <textarea id="" name="msg" cols="30" rows="7" placeholder="Your message here.."></textarea>
              </div>
              <div class="clearfix"><input type="submit" value="Send"></div>
            </form>
          </div>

        </div>
      </section>

    </div>
  </div>
</body>
</html>