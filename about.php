<?php include('components/head.php') ?>

<body>

    <div class="cursor"></div>

    <div class="homepage">

    <?php include('components/navbar.php') ?>
    </div>

    <section class="about">

        <div class="about-x">
            <p class="about-title">ABOUT <span>OJ STUDIOLIVE</span></p>

            <P class="about-slogan">DESIGN-INNOVATION-CREATIVITY</P>

            <p class="about-text">OJ StudioLive is an IT company based in Accra, Ghana. We provide design and
                development solutions from research to implementation to our clients that we consider as partners. To
                make our clients and their users 100% satisfied, we always arm ourselves with the following values:
                patience, communication, satisfaction.</p>
        </div>

        <div class="about-x">
            <p class="about-title">ABOUT <span>THE BUSINESS GROWTH PROGRAM</span></p>

            <P class="about-slogan">INVEST-CHANGE-EVOLVE</P>

            <p class="about-text">To support young entrepreneurs and struggling businesses, we developped the Business
                Growth Program. The Business Growth Program is an alternative option for upcoming and entrepreneurs to
                invest in the digitilization of their businesses without worrying about outrageous costs. The Business
                Growth Program will enable their benefeciators to receive a reasonable discount on their projects and
                invest in them on a monthly basis until total payment is completed. Apply <span><a
                        href="growthprogram.php">here.</a></span></p>
        </div>

        <div class="about-x">
            <p class="about-title">ABOUT <span>THE STUDIOCOMMUNITY</span></p>

            <P class="about-slogan">INSPIRE-LOVE-EDUCATE</P>

            <p class="about-text">The StudioCommunity is an initiative of OJ StudioLive to significally diminish the
                risk of poverty among young people. Our goal is to help educate people of all ages, especially young
                adolescents and to give them the right tools they need to be able to flow in society. We will offer IT,
                Design, Finance and English courses and follow the progress of the participants even after the
                completion of the program. The StudioCommunity doors are also open for reading and we are setting up a
                program for kids as well. Note that a percentage of all our remuneration goes into funding the program
                and gifting our participants with gadgets such as laptops and school items.</p>
        </div>
    </section>

    <?php include('components/footer.php') ?>

    <script src="./js/main.js"></script>

    <script>
        const mobileBtn = document.getElementById('mobile-cta')
        nav = document.querySelector('nav')
        mobileBtnExit = document.getElementById('menuclose')

        mobileBtn.addEventListener('click', () => {
            nav.classList.add('mobile-menu');
        })

        mobileBtnExit.addEventListener('click', () => {
            nav.classList.remove('mobile-menu');
        })
    </script>

</body>

</html>