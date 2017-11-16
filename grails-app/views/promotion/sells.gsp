<!doctype html>
<html>

<g:render template="/head"/>

<header class="mui-appbar mui--z1" style="background-color: #0DB0F3">
    <div class="mui-container">
        <table>
            <tr class="mui--appbar-height">
                <td class="mui--text-title"><a href="../../"><b>Quiero!</b> Más Descuentos</a></td>
                <td class="mui--text-right">
                    <ul class="mui-list--inline mui--text-body2">
                        <li><a href="../analytics/${session.merchantId}">Analytics</a></li>
                        <li><a href="../promotion/create">Publicar</a></li>
                        <li><a href="../logout">${session.user}</a></li>
                    </ul>
                </td>
            </tr>

        </table>
    </div>
</header>

<body>
<div id="content-wrapper" class="mui--text-center">
    <div class="mui--appbar-height"></div>

    <div class="mui--appbar-height"></div>
    <g:if test="${(sells.size() == 0 && noGaliciaSells.size() == 0)}">
        <div class="mui--text-display3" style="margin-bottom: 2%">Aun no tienes ventas</div>
    </g:if>

    <g:if test="${sells}">
    <div class="mui-panel">
        <div class="mui--text-display3" style="margin-bottom: 2%">Ventas usuarios galicia</div>

        <div class="mui-row">
            <g:each status="iteration" var="sell" in="${sells}">
                <g:render template="/promotion/sell" model="[sell: sell, client: clients[iteration]]"/>
            </g:each>
        </div>
    </div>
    </g:if>

    <g:if test="${noGaliciaSells}">
    <div class="mui-panel">
        <div class="mui--text-display3" style="margin-bottom: 2%">Ventas otros usuarios</div>

        <div class="mui-row">
            <g:each status="iteration" var="sell" in="${noGaliciaSells}">
                <g:render template="/promotion/noClientSell" model="[sell: sell]"/>
            </g:each>
        </div>
    </div>
    </g:if>
</div>

</body>

<g:render template="/footer"/>
</html>


