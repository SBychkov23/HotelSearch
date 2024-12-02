<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'search-form.css')}" type="text/css">
    <title>Hotel Search</title>
</head>
<body>

    <div class="nav" role="navigation">
                <ul>
                    <li><a class="home" href="${createLink(uri: '/')}"><g:message code="Главная"/></a></li>
                    <li><g:link controller="country" action="index"><g:message code="Страны" args="[entityName]" /></g:link></li>
                    <li><g:link controller="hotel" action="index"><g:message code="Отели" args="[entityName]" /></g:link></li>
                </ul>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Поиск</h1>
            <g:form class="searchContainer" controller="home" action="searchResults">
                     <g:textField name="hotelName" value="${hotelName}" />
                        <g:select name="countryName" value="${countryName}" from="${countryList}" optionKey="countryName" />
                           <input type="submit" value="Поиск">
            </g:form>
        </section>
                <g:if test="${showResults!=null}" >
                    <g:if test="${resultsNum!=0}" >
                        <h1>Найдено отелей: ${resultsNum}</h1>
                    </g:if>
                    <g:else>
                       <h1>По Вашему запросу ничего не найдено</h1>
                    </g:else>
                </g:if>
                <table>
                    <tr>
                        <th>Название отеля</th>
                        <th>Звездность</th>
                        <th>Сайт</th>
                    </tr>
                    <g:each in="${results}" >
                        <tr>
                            <td>${it.hotelName}</td>
                            <td>${it.hotelRating}</td>
                            <g:if test="${it.webSite!=null}">
                            <td><a href=${it.webSite} target="_blank">Перейти на сайт</a></td>
                            </g:if>
                        </tr>
                    </g:each>
                </table>
                <div class="pagination">
                                 <g:paginate params="${params}" total="${resultsNum}" />
                            </div>

        </div>


    </div>

</body>
</html>
