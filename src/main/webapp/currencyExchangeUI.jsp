<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Exchange</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .result {
            margin-top: 20px;
            padding: 10px;
            background-color: #f8f9fa;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Currency Exchange</h2>
        <form action="exchange" method="post">
            <div class="form-group">
                <label for="amount">Amount</label>
                <input type="text" id="amount" name="amount" required value="${amount}" />
            </div>

            <div class="form-group">
                <label for="fromCurrency">From Currency</label>
                <select id="fromCurrency" name="fromCurrency">
					<option value="">Select From Currency</option>
                    <option value="USD"  <% if(("USD").equals(request.getAttribute("fromCurrency"))){ %> selected <% } %> >USD</option>
                    <option value="EUR"  <% if(("EUR").equals(request.getAttribute("fromCurrency"))){ %> selected <% } %> >EUR</option>
                    <option value="GBP"  <% if(("GBP").equals(request.getAttribute("fromCurrency"))){ %> selected <% } %> >GBP</option>
                    <option value="INR"  <% if(("INR").equals(request.getAttribute("fromCurrency"))){ %> selected <% } %> >INR</option>
                </select>
            </div>

            <div class="form-group">
                <label for="toCurrency">To Currency</label>
                <select id="toCurrency" name="toCurrency">
					<option value="">Select to Currency</option>
                    <option value="USD" <% if(("USD").equals(request.getAttribute("toCurrency"))) { %> selected <% } %> >USD</option>
                    <option value="EUR" <% if(("EUR").equals(request.getAttribute("toCurrency"))) { %> selected <% } %> >EUR</option>
                    <option value="GBP" <% if(("GBP").equals(request.getAttribute("toCurrency"))) { %> selected <% } %> >GBP</option>
                    <option value="INR"<% if(("INR").equals(request.getAttribute("toCurrency"))) { %> selected <% } %> >INR</option>
                </select>
            </div>

            <button type="submit" class="btn">Convert</button>
        </form>
		
		<% if(request.getAttribute("exchangedValue")!=null){ %>
        <div class="result">
            <p><strong>Converted Amount:</strong> ${exchangedValue} ${toCurrency}</p>
        </div>
		<%} else if (request.getAttribute("exchangeError")!=null){ %>
			<div class="error">
			           <p><strong>Error in conversion:</strong> ${exchangeError}</p>
			 </div>
			<%}%>
    </div>
</body>
</html>
