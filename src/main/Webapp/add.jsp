<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Article</title>
</head>
<body>
    <h2>Add Article</h2>
    <form:form method="POST" modelAttribute="article" action="${pageContext.request.contextPath}/articles/add">
        <form:label path="title">Title:</form:label>
        <form:input path="title" /><br/>
        
        <form:label path="description">Description:</form:label>
        <form:textarea path="description" /><br/>
        
        <form:label path="publishDate">Publish Date:</form:label>
        <form:input path="publishDate" type="date" /><br/>
        
        <form:label path="status">Status:</form:label>
        <form:input path="status" /><br/>
        
        <form:label path="banner">Banner:</form:label>
        <form:input path="banner" /><br/>
        
        <form:label path="author">Author:</form:label>
        <form:select path="author.id">
            <form:options items="${authors}" itemValue="id" itemLabel="name" />
        </form:select><br/>
        
        <input type="submit" value="Add Article" />
    </form:form>
</body>
</html>