<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'hotel.label', default: 'Hotel')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-hotel" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="Главная"/></a></li>
                               <li><g:link class="list" action="index"><g:message code="Справочник отелей" args="[entityName]" /></g:link></li>
                               <li><g:link class="create" action="create"><g:message code="Добавить отель" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-hotel" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="hotel" />
            <g:form resource="${this.hotel}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.hotel}"><g:message code="Редактировать" default="Редактировать" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'Удалить', default: 'Удалить')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
