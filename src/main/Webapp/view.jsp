<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Article</title>
</head>
<body>
    <h2>View Article</h2>
    <p><strong>Title:</strong> ${article.title}</p>
    <p><strong>Description:</strong> ${article.description}</p>
    <p><strong>Publish Date:</strong> ${article.publishDate}</p>
    <p><strong>Status:</strong> ${article.status}</p>
    <p><strong>Banner:</strong> ${article.banner}</p>
    <p><strong>Author:</strong> ${article.author.name}</p>
    <a href="${pageContext.request.contextPath}/articles/list">Back to List</a>
</body>
</html>
