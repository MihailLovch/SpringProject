<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:page title="Cabinet" >

    <main class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
        <div id="all-info" style="text-align: center; position:relative; margin-top: 20px">
            <div id="calories-pb" style="display: inline-block">
                <t:progress title="Calories analysis" category="Calories" max="${dashboard.maxCalories}"
                            consumed="${dashboard.record.calorie}"/>
            </div>
            <div style="display: flex">
                <div id="pcarbs">
                    <t:progress title="Carbs analysis" category="Carbs" max="${dashboard.maxCarb}"
                                consumed="${dashboard.record.carb}"/>
                </div>
                <div id="pfats">
                    <t:progress title="Fats analysis" category="Fats" max="${dashboard.maxFat}"
                                consumed="${dashboard.record.fat}" />
                </div>
                <div id="pproteins">
                    <t:progress title="Proteins analysis" category="Proteins" max="${dashboard.maxProteins}"
                                consumed="${dashboard.record.proteins}" />
                </div>
            </div>
        </div>
    </main>
</t:page>
