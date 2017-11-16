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
                        <li><a href="../sells/${session.merchantId}">Ventas</a></li>
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

    <g:if test="${galicia}">
        <div class="mui-panel">
            <div id="galicia" style="width:100%; height:400px; margin-top: 5%"></div>
        </div>
    </g:if>
    <g:else>
        <div class="mui--text-display3" style="margin-bottom: 2%">Aun no tienes ventas</div>
    </g:else>

</div>
</body>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<script>
    Highcharts.chart('galicia', {
        chart: {
            type: 'spline'
        },
        title: {
            text: 'Cantidad de ventas'
        },
        xAxis: {
            type: 'datetime',
            title: {
                text: 'Fechas'
            },
        },
        yAxis: {
            title: {
                text: 'Ventas'
            },
            min: 0
        },
        tooltip: {
            headerFormat: '<b>{series.name}</b><br>',
            pointFormat: '{point.x:%e. %b}: {point.y:.2f} m'
        },

        plotOptions: {
            spline: {
                marker: {
                    enabled: true
                }
            }
        },

        series: [
            {
                name: 'Ventas Usuarios Galicia',
                data: ${galicia}
            },
            {
                name: 'Ventas Otros Usuarios',
                data: ${others}
            }
        ]
    });
</script>

<g:render template="/footer"/>
</html>


