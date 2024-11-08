<!DOCTYPE html>
<html>
<head>
    <title>Create Software</title>
</head>
<body>
    <h2>Create New Software</h2>
    <form action="SoftwareServlet" method="post">
        Name: <input type="text" name="name" required><br>
        Description: <textarea name="description"></textarea><br>
        Access Levels: <br>
        <input type="checkbox" name="accessLevels" value="Read"> Read<br>
        <input type="checkbox" name="accessLevels" value="Write"> Write<br>
        <input type="checkbox" name="accessLevels" value="Admin"> Admin<br>
        <input type="submit" value="Create Software">
    </form>
</body>
</html>
