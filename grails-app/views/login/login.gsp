<!doctype html>
<html>

<g:render template="/head"/>

<header class="mui-appbar mui--z1" style="background-color: #0DB0F3">
    <div class="mui-container">
        <table>
            <tr class="mui--appbar-height">
                <td class="mui--text-title"><a href="../"><b>Quiero!</b> Más Descuentos</a></td>
                <td class="mui--text-right">
                    <ul class="mui-list--inline mui--text-body2">
                        <li><a href="../register">Registrarse</a></li>
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

    <div class="mui-row">

        <div class="mui--text-display3">Login</div>

        <div class="mui-col-lg-6 mui-col-md-offset-3" style="margin-top: 5%">
            <div class="mui-panel">
                <g:form url="${createLink(uri: "/login")}" method="POST" class="mui-form">

                    <div class="mui-textfield">
                        <label style="text-align: left">Nombre</label>
                        <input type="text" name="merchantName">
                    </div>

                    <button type="submit" class="mui-btn mui-btn--primary">Submit</button>
                </g:form>
            </div>

            <g:if test="${msg}">
                <div class="mui-panel" style="text-align: center; color: red;">
                    <p>${msg}</p>
                </div>
            </g:if>
        </div>
    </div>
</div>

<g:render template="/footer"/>

</body>
</html>


