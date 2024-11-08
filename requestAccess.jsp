<!DOCTYPE html>
<html>
<head>
    <title>Request Access</title>
</head>
<body>
    <h2>Request Access</h2>
    <form action="RequestServlet" method="post">
        Software: 
        <select name="softwareId" required>
            <!-- Dynamically populate this list based on available software -->
            <option value="1">Example Software 1</option>
            <option value="2">Example Software 2</option>
        </select><br>
        Access Type: 
        <select name="accessType" required>
            <option value="Read">Read</option>
            <option value="Write">Write</option>
            <option value="Admin">Admin</option>
        </select><br>
        Reason for Request: <br>
        <textarea name="reason" required></textarea><br>
        <input type="submit" value="Request Access">
    </form>
</body>
</html>
