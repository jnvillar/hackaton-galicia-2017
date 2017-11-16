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

        <div class="mui--text-display3">Editar Promoción</div>

        <div class="mui-col-lg-6 mui-col-md-offset-3" style="margin-top: 5%">
            <div class="mui-panel">
                <g:form url="${createLink(uri: "/promotion/edit/${promotion.id}")}" method="POST" class="mui-form">

                    <div class="mui-textfield">
                        <label style="text-align: left">Nombre</label>
                        <input type="text" name="name" required value="${promotion.name}">
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Vencimiento</label>
                        <input type="datetime-local" name="endDate" required>
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Link Imagen</label>
                        <input type="text" name="image" required value="${promotion.image}">
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Precio</label>
                        <input type="number" min="0.00" name="price" required value="${promotion.price}">
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Descuento</label>
                        <input type="number" min="0" max="100" name="discount" required value="${promotion.discount}">
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Puntos Quiero</label>
                        <input type="number" min="0" name="rewards" required value="${promotion.rewards}">
                    </div>

                    <div class="mui-textfield">
                        <label style="text-align: left">Stock</label>
                        <input type="number" min="1" name="stock" required value="${promotion.stock}">
                    </div>

                    <div class="mui-textfield">
                        <textarea name="description" required>${promotion.description}</textarea>
                        <label style="text-align: left">Descripcion</label>
                    </div>
                    <button type="submit" class="mui-btn mui-btn--primary">Submit</button>
                    <button id="delete" class="mui-btn mui-btn--primary">Borrar</button>

                </g:form>

            </div>
        </div>
    </div>

</div>

<g:javascript>

   document.getElementById("delete").onclick = function(){

        $.get("/promotion/delete",
        {
            promotionId: ${promotion.id}
    },
    function (data, status) {
        window.location.href = "../../"
    });
};

</g:javascript>

<g:render template="/footer"/>

</body>
</html>


