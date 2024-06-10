<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List of Articles</title>
</head>
<body>
    <h2>List of Articles</h2>
    <form action="${pageContext.request.contextPath}/articles/list" method="get">
        <input type="text" name="search" placeholder="Search by title" value="${param.search}" />
        <input type="submit" value="Search" />
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Publish Date</th>
                <th>Status</th>
                <th>Author</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="article" items="${articles}">
                <tr>
                    <td>${article.title}</td>
                    <td>${article.description}</td>
                    <td>${article.publishDate}</td>
                    <td>${article.status}</td>
                    <td>${article.author.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/articles/view/${article.id}">View</a>
                        <a href="${pageContext.request.contextPath}/articles/update/${article.id}">Update</a>
                        <a href="${pageContext.request.contextPath}/articles/delete/${article.id}" onclick="return confirm('Are you sure you want to delete this article?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/articles/add">Add New Article</a>
</body>
</html>
