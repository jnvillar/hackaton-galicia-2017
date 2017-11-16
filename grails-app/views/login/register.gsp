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

    <div class="mui-row">

        <div class="mui--text-display3">Registro</div>

        <div class="mui-col-lg-6 mui-col-md-offset-3" style="margin-top: 5%">
            <div class="mui-panel">
                <g:form url="${createLink(uri: "/register")}" method="POST" class="mui-form">

                    <div class="mui-textfield">
                        <label style="text-align: left">Nombre</label>
                        <input type="text" name="name" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Categoria</label>
                        <input type="text" name="category" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Calle</label>
                        <input type="text" name="streetName" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Numero calle</label>
                        <input type="number" min="0" name="streetNumber" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Ciudad</label>
                        <input type="text" min="0" max="100" name="city" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Estado</label>
                        <input type="text" min="0" name="state" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Zip</label>
                        <input type="number" min="0" name="zip" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Lat</label>
                        <input type="text" min="0" name="lat" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Long</label>
                        <input type="text" min="0" name="lng" required>
                    </div>


                    <button type="submit" class="mui-btn mui-btn--primary">Submit</button>
                </g:form>
            </div>
        </div>
    </div>

</div>

<g:render template="/footer"/>

</body>
</html>


