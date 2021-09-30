<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NVV</title>
    <link href="<c:url value="/resources/theme/css/bootstrap.css" />" rel="stylesheet">
</head>

<body>
<div>
    <h1>Information details: </h1>
</div>

<div class="container" style="margin-left: auto; margin-top: 10%; width: 50%; border: 3px solid green; padding: 10px; text-align: center">
    <h1>Confirm information: </h1>
    <form action="confirmRegistration" method="get">
        <!-- 2 column grid layout with text inputs for the first and last names -->
        <div class="row mb-4">
            <div class="col">
                <div class="form-outline">
                    <input type="text" id="crl_1" class="form-control" name="form_FirstName" placeholder="${param.form_FirstName}" readonly>
                    <label class="form-label" for="crl_1">First name</label>
                </div>
            </div>
            <div class="col">
                <div class="form-outline">
                    <input type="text" id="crl_2" class="form-control" name="form_LastName"
                           placeholder="${param.form_LastName}" readonly>
                    <label class="form-label" for="crl_2">Last name</label>
                </div>
            </div>
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">
            <input type="text" id="crl_3" class="form-control" name="form_companyName" placeholder="${param.form_companyName}" readonly>
            <label class="form-label" for="crl_3">Company name</label>
        </div>

        <!-- Text input -->
        <div class="form-outline mb-4">
            <input type="text" id="crl_4" class="form-control" name="form_Address" placeholder="${param.form_Address}" readonly>
            <label class="form-label" for="crl_4">Address</label>
        </div>

        <!-- Email input -->
        <div class="form-outline mb-4">
            <input type="email" id="crl_5" class="form-control" name="form_Email" placeholder="${param.form_Email}" readonly>
            <label class="form-label" for="crl_5">Email</label>
        </div>

        <!-- Number input -->
        <div class="form-outline mb-4">
            <input type="number" id="crl_6" class="form-control" name="form_Phone" placeholder="${param.form_Phone}" readonly>
            <label class="form-label" for="crl_6">Phone</label>
        </div>

        <!-- Message input -->
        <div class="form-outline mb-4">
            <textarea class="form-control" id="crl_7" rows="4" name="form_AdditionalInfo"
                      placeholder="${param.form_AdditionalInfo}" readonly></textarea>
            <label class="form-label" for="crl_7">Additional information</label>
        </div>

        <!-- Submit button -->
        <button type="submit" class="btn btn-primary btn-block mb-4">Confirm</button>
    </form>
</div>

</body>

</html>
