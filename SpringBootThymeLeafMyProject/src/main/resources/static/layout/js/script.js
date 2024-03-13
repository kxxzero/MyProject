// glamping-N33 [wiLsbidq4n]
(function() {
  $(function() {
    $(".glamping-N33").each(function() {
      const $block = $(this);
      const $calendar = $block.find(".contents-date")
      // Date Range Picker
      $calendar.dateRangePicker({
        container: '.glamping-N33 .contents-top',
        // language:'ko',
        language: 'custom',
        inline: true,
        alwaysOpen: true,
      }).bind('datepicker-first-date-selected', function(event, obj) {
        console.log(obj);
      }).bind('datepicker-change', function(event, obj) {
        console.log(obj);
      });
      // Amount Count Button Click Event
      $block.find(".contents-amount").each(function() {
        const $this = $(this);
        const $amountNumElement = $this.find(".contents-amount-num span");
        $this.on("click", ".btn-minus", function() {
          let amountNum = parseInt($amountNumElement.text());
          if (amountNum > 1) {
            amountNum--;
          }
          $amountNumElement.text(amountNum);
        });
        $this.on("click", ".btn-plus", function() {
          let amountNum = parseInt($amountNumElement.text());
          amountNum++;
          $amountNumElement.text(amountNum);
        });
      });
    });
  });
})();