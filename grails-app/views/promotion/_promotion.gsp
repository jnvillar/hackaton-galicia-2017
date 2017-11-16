<div class="mui-col-md-3" onClick="window.location = '/promotion/edit/${promotion.id}'">
    <div class="mui-panel" style="font-family: Verdana">
        <div style="font-size: large">
            <b>${promotion.name}</b>
        </div>

        <div style="color: darkgray; font-size: large">
            Vence: ${promotion.endDate}
        </div>

        <div style="margin-top: 2%; height: 300px" >
            <img src="${promotion.image}" style='height: 100%; width: 100%; margin: auto;display: block'/>
        </div>

        <div style="color: darkgray; font-size: large">
            Descuento: ${promotion.discount}
        </div>

        <div style="color: darkgray; font-size: large">
            Puntos QUIERO: ${promotion.rewards}
        </div>

        <div style="color: darkgray; font-size: large">
            Stock: ${promotion.stock}
        </div>

        <div style="display: block">
            <div style="color: darkgray; font-size: medium; float: left">
                Precio: ${promotion.price}
            </div>

            <g:if test="${promotion.discount != 0}">
                <div style="color: darkgray; font-size: medium; float: right">
                    Final: ${(promotion.price - (promotion.price * promotion.discount / 100)).round(3)}
                </div>
            </g:if>
            <g:else>
                <div style="color: darkgray; font-size: medium; float: right">
                    Final: ${promotion.price}
                </div>
            </g:else>

        </div>

    </div>
</div>