// Main Visual
// glamping-N4 [BELSBICwJu]
(function() {
  $(function() {
    $(".glamping-N4").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".glamping-N4 .contents-swiper", {
        slidesPerView: 1,
        spaceBetween: 0,
        allowTouchMove: false,
        loop: true,
        autoplay: {
          delay: 5000,
        },
        pagination: {
          el: ".glamping-N4 .swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".glamping-N4 .swiper-button-next",
          prevEl: ".glamping-N4 .swiper-button-prev",
        },
      });
      // Swiper Play, Pause Button
      const pauseButton = $block.find('.swiper-button-pause');
      const playButton = $block.find('.swiper-button-play');
      playButton.hide();
      pauseButton.show();
      pauseButton.on('click', function() {
        swiper.autoplay.stop();
        playButton.show();
        pauseButton.hide();
      });
      playButton.on('click', function() {
        swiper.autoplay.start();
        playButton.hide();
        pauseButton.show();
      });
    });
  });
})();

// Cookie
// glamping-N7 [PQLsBIcWvM]
(function() {
  $(function() {
    $(".glamping-N7").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".glamping-N7 .contents-swiper", {
        slidesPerView: 'auto',
        spaceBetween: 0,
        allowTouchMove: false,
        loop: true,
        pagination: {
          el: ".glamping-N7 .swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".glamping-N7 .swiper-button-next",
          prevEl: ".glamping-N7 .swiper-button-prev",
        },
      });
    });
  });
})();

// SubDetail
// glamping-N29 [HrLTc8lsbg]
(function() {
  $(function() {
    $(".glamping-N29").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".glamping-N29 .contents-swiper", {
        slidesPerView: 'auto',
        centeredSlides: true,
        spaceBetween: 0,
        allowTouchMove: false,
        loop: true,
        autoplay: {
          delay: 2000,
        },
        navigation: {
          nextEl: ".glamping-N29 .swiper-button-next",
          prevEl: ".glamping-N29 .swiper-button-prev",
        },
      });
    });
  });
})();
