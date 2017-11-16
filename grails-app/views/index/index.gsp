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
                        <li><a href="analytics/${session.merchantId}">Analytics</a></li>
                        <li><a href="sells/${session.merchantId}">Ventas</a></li>
                        <li><a href="promotion/create">Publicar</a></li>
                        <li><a href="/logout">${session.user}</a></li>
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

    <g:if test="${promotions}">
        <div class="mui-panel">
            <div class="mui--text-display3" style="margin-bottom: 2%">Tus Promociones</div>

            <div class="mui-row">
                <g:each var="promotion" in="${promotions}">
                    <g:render template="/promotion/promotion" model="[promotion: promotion]"/>
                </g:each>
            </div>
        </div>
    </g:if>
    <g:else>
        <div class="mui-panel">
            <div class="mui--text-display3" style="margin-bottom: 10%">Sin Promociones Activas</div>
        </div>
    </g:else>

    <g:if test="${oldPromotions}">
        <div class="mui-panel">
            <div class="mui--text-display3" style="margin-bottom: 2%; margin-top: 2%">Promociones Caducadas</div>

            <div class="mui-row">
                <g:each var="promotion" in="${oldPromotions}">
                    <g:render template="/promotion/promotion" model="[promotion: promotion]"/>
                </g:each>
            </div>
        </div>
    </g:if>
</div>
</body>

<g:render template="/footer"/>
</html>


