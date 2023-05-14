<script th:inline="javascript">
    $(document).on('ready', function (e) {
    var form= $("#form");
    var reviewId= [[${editReview.reviewId}]];
    $(document).on('click', '#review-cancel-button', function (e) {
    $('#form').attr("action","delete");
    form.append("<input type='hidden' name='reviewId' value='"+reviewId+"'>");
    form.append("<input type='hidden' name='_method' value='delete'>");
    form.submit();
    })

    $(document).on('click','#review-edit-button',function (e) {
    var str="<select class="star_select" id="review-star" name="star" th:field="*{star}">
                           <option value="1">1</option>
                           <option value="2">2</option>
                           <option value="3">3</option>
                           <option value="4">4</option>
                           <option value="5">5</option>
                         </select>";
    $("#star").html(str);
    str="<input type="text" id="review-content" name="content" th:field="*{content}" />";
    $("#content").html(str);
    $("#review-edit-button").attr("id","review-edit-button");

    })

    $(document).on('click','#review-edit-button',function (e){
    $('#form').attr("action","update");
    var updateStar= $('#updateStar').val();
    var updateContent=$('#updateContent').val();
    form.append("<input type='hidden' name='reviewId' value='"+reviewId+"'>");
    form.append("<input type='hidden' name='_method' value='put'>");
    form.append("<input type='hidden' name='star' value='"+updateStar+"'>");
    form.append("<input type='hidden' name='content' value='"+updateContent+"'>");
    form.submit();

})
})
