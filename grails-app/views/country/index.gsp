<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'country.label', default: 'Country')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-country" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="Главная"/></a></li>
                <li><g:link class="create" action="create"><g:message code="Добавить страну" args="[entityName]" /></g:link></li>
            </ul>
        </div>
            <g:if test="${countryList}" >
                                <g:if test="${countryList!=null}">
                                    <h1>Справочник стран</h1>
                                </g:if>
                                <table>
                                    <tr>
                                        <th>Название страны</th>
                                        <th>Столица</th>
                                        <th></th>
                                        <th></th>

                                    </tr>
                                    <g:each in="${countryList}">
                                        <tr>
                                            <td>${it.countryName}</td>
                                            <td>${it.capitalName}</td>
                                            <td><li><g:link class="edit" action="edit" resource="${it}"><g:message code="Редактировать" default="Редактировать" /></g:link></li></td>
                                            <td> <g:form resource="${it}" method="DELETE"><input class="delete" type="submit" value="${message(code: 'Удалить', default: 'Удалить')}"
                                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Вы уверены?')}');" />
                                            </g:form>
                                            </td>
                                        </tr>
                                    </g:each>
                                </table>
                    </g:if>
                    <div class="pagination">
                                            <g:paginate total="${countryCount}" />
                     </div>
        </div>
    </body>
</html>