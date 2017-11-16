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

        <div class="mui--text-display3">Nueva Promoción</div>

        <div class="mui-col-lg-6 mui-col-md-offset-3" style="margin-top: 5%">
            <div class="mui-panel">
                <g:form url="${createLink(uri: "/promotion/create")}" method="POST" class="mui-form">

                    <div class="mui-textfield">
                        <label style="text-align: left">Nombre</label>
                        <input type="text" name="name" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Vencimiento</label>
                        <input type="datetime-local" name="endDate" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Link Imagen</label>
                        <input type="text" name="image" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Precio</label>
                        <input type="number" min="0.00" step="0.01" name="price" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Descuento</label>
                        <input type="number" min="0" max="100" name="discount" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Puntos Quiero</label>
                        <input type="number" min="0" name="rewards" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Stock </label>
                        <input type="number" min="1" name="stock" required>
                    </div>

                    <div class="mui-textfield">
                        <textarea name="description" required></textarea>
                        <label style="text-align: left">Descripcion</label>
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


