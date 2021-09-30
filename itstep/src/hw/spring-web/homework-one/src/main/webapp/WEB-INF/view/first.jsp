<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>


    <link href="<c:url value="/resources/theme/css/bootstrap.css" />" rel="stylesheet">


</head>
<body>

<div class="container" style="margin-left: auto; margin-top: 10%; width: 50%; border: 3px solid green; padding: 10px; text-align: center">
    <h1>I like Spring</h1>
    <form action="confirm" method="get">
        <!-- 2 column grid layout with text inputs for the first and last names -->
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <input type="text" class="form-control" name="form_FirstName" placeholder="Your name">
                </div>
            </div>
            <div class="col">
                <div class="form-outline">
                    <input type="text" class="form-control" name="form_LastName" placeholder="Your last name">
                </div>
            </div>
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">
            <input type="text" class="form-control" name="form_companyName" placeholder="Your company name">
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">
            <input type="text" class="form-control" name="form_Address" placeholder="Your address">
        </div>

        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="email" class="form-control" name="form_Email" placeholder="Your email">
        </div>

        <!-- Number input -->
        <div class="form-outline mb-4">
            <input type="number" class="form-control" name="form_Phone" placeholder="Your phone">
        </div>

        <!-- Message input -->
        <div class="form-outline mb-4">
            <textarea class="form-control" rows="4" name="form_AdditionalInfo"
                      placeholder="Your additional information"></textarea>

        </div>
        <!-- Checkbox -->
        <div class="form-check d-flex justify-content-center mb-4">
            <input class="form-check-input me-2" type="checkbox" onclick="setValue()" id="crl_8" checked>
            <input type="hidden" name="form_Create" value="true" id="crl_8_1"/>
            <label class="form-check-label" for="crl_8"> Create an account? </label>
        </div>

        <!-- Submit button -->
        <%--            <input type="submit" class="btn btn-primary btn-block mb-4"></input>--%>
        <button type="submit" class="btn btn-primary btn-block mb-4">Next</button>

        <script>
            function setValue() {
                let checkBox = document.getElementById("crl_8");
                let element = document.getElementById("crl_8_1");
                if (checkBox.checked == true) {

                    element.value = "true"
                } else {
                    element.value = "false"
                }
            }
        </script>
    </form>
</div>

</body>
</html>
