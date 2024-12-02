<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="Главная"/></a></li>
                <li><g:link class="create" action="create"><g:message code="Добавить отель" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <g:if test="${hotelList}" >
                    <g:if test="${hotelList!=null}">
                        <h1>Справочник отелей</h1>
                    </g:if>
                    <table>
                        <tr>
                            <th>Название отеля</th>
                            <th>Звездность</th>
                            <th>Страна</th>
                            <th>Сайт</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <g:each in="${hotelList}">
                            <tr>
                                <td>${it.hotelName}</td>
                                <td>${it.hotelRating}</td>
                                <td>${it.country}</td>
                                    <g:if test="${it.webSite!=null}">
                                        <td><g:link base="${it.webSite}">Перейти на сайт</g:link></td>
                                    </g:if>
                                    <g:else>
                                       <td></td>
                                    </g:else>
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
                                <g:paginate total="${hotelCount}" />
         </div>
    </body>
</html>