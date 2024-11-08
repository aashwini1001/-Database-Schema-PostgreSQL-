<!DOCTYPE html>
<html>
<head>
    <title>Pending Requests</title>
</head>
<body>
    <h2>Pending Access Requests</h2>
    <!-- Replace this static table with dynamic data from the database -->
    <table border="1">
        <tr>
            <th>Employee Name</th>
            <th>Software</th>
            <th>Access Type</th>
            <th>Reason</th>
            <th>Actions</th>
        </tr>
        <tr>
            <td>John Doe</td>
            <td>Example Software 1</td>
            <td>Read</td>
            <td>Access needed for project work.</td>
            <td>
                <form action="ApprovalServlet" method="post" style="display:inline;">
                    <input type="hidden" name="requestId" value="1">
                    <input type="hidden" name="action" value="Approve">
                    <input type="submit" value="Approve">
                </form>
                <form action="ApprovalServlet" method="post" style="display:inline;">
                    <input type="hidden" name="requestId" value="1">
                    <input type="hidden" name="action" value="Reject">
                    <input type="submit" value="Reject">
                </form>
            </td>
        </tr>
        <!-- Add more rows based on actual requests -->
    </table>
</body>
</html>
