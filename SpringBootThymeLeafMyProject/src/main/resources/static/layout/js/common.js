// glamping-N1 [MnLSbICwb0]
(function() {
  $(function() {
    $(".glamping-N1").each(function() {
      const $block = $(this);
      // Header Scroll
      $(window).on("load scroll", function() {
        const $thisTop = $(this).scrollTop();
        if ($thisTop > 0) {
          $block.addClass("header-top-active");
        } else {
          $block.removeClass("header-top-active");
        }
      });
      // Gnb
      $block.find(".header-center").on("mouseover", function() {
        if (window.innerWidth > 992) {
          $block.addClass("block-active");
        }
      });
      $block.find(".header-center").on("mouseout", function() {
        if (window.innerWidth > 992) {
          $block.removeClass("block-active");
        }
      });
      // Gnb DecoLine
      $block.find(".header-gnbitem").each(function() {
        const $this = $(this);
        $this.on("mouseover", function() {
          if (window.innerWidth > 992) {
            $this.find(".header-gnblink").addClass("on");
          }
        });
        $this.on("mouseout", function() {
          if (window.innerWidth > 992) {
            $this.find(".header-gnblink").removeClass("on");
          }
        });
      });
      // Mobile Top
      $block.find(".btn-momenu").on("click", function() {
        $block.addClass("mo-active");
      });
      $block.find(".btn-moclose").on("click", function() {
        $block.removeClass("mo-active");
      });
      // Mobile Gnb
      $block.find(".header-gnbitem").each(function() {
        const $this = $(this);
        const $thislink = $this.find(".header-gnblink");
        $thislink.on("click", function() {
          if (!$(this).parent().hasClass("item-active")) {
            $(".header-gnbitem").removeClass("item-active");
          }
          $(this).parents(".header-gnbitem").toggleClass("item-active");
        });
      });
      // Full Gnb
      $block.find(".btn-allmenu").on("click", function() {
        $block.find(".header-fullmenu").addClass("fullmenu-active");
      });
      $block.find(".fullmenu-close").on("click", function() {
        $block.find(".header-fullmenu").removeClass("fullmenu-active");
      });
      // Full Gnb DecoLine
      $block.find(".fullmenu-gnbitem").each(function() {
        const $this = $(this);
        $this.on("mouseover", function() {
          if (window.innerWidth > 992) {
            $this.find(".fullmenu-gnblink").addClass("on");
          }
        });
        $this.on("mouseout", function() {
          if (window.innerWidth > 992) {
            $this.find(".fullmenu-gnblink").removeClass("on");
          }
        });
      });
      // Header Mobile 1Depth Click
      if (window.innerWidth <= 992) {
        $block.find(".header-gnbitem").each(function() {
          const $gnblink = $(this).find(".header-gnblink");
          const $sublist = $(this).find(".header-sublist");
          if ($sublist.length) {
            $gnblink.attr("href", "javascript:void(0);");
          }
        });
      }
    });
  });
})();
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
// glamping-N9 [UTlSBICX2S]
(function() {
  $(function() {
    $(".glamping-N9").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".glamping-N9 .contents-swiper", {
        slidesPerView: 'auto',
        spaceBetween: 0,
        allowTouchMove: false,
        loop: true,
        autoplay: {
          delay: 3000,
        },
        navigation: {
          nextEl: ".glamping-N9 .swiper-button-next",
          prevEl: ".glamping-N9 .swiper-button-prev",
        },
      });
    });
  });
})();
// glamping-N29 [HrLTc8lsbg]
(function() {
  $(function() {
    $(".glamping-N29").each(function() {
      const $block = $(this);
      // Swiper
      const swiper = new Swiper(".glamping-N29 .contents-swiper", {
        slidesPerView: 'auto',
        spaceBetween: 0,
        allowTouchMove: false,
        loop: true,
        autoplay: {
          delay: 3000,
        },
        navigation: {
          nextEl: ".glamping-N29 .swiper-button-next",
          prevEl: ".glamping-N29 .swiper-button-prev",
        },
      });
    });
  });
})();