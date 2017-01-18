(function (global) {
    System.config({
        paths: {
            // paths serve as alias
            'npm:': 'node_modules/'
        },
        // map tells the System loader where to look for things
        map: {
            // our app is within the target/scala-2.11 folder
            app: 'target/scala-2.11',
            // angular bundles
            '@angular/core': 'https://unpkg.com/@angular/core@2.4.2/bundles/core.umd.js',
            '@angular/common': 'https://unpkg.com/@angular/common@2.4.2/bundles/common.umd.js',
            '@angular/compiler': 'https://unpkg.com/@angular/compiler@2.4.2/bundles/compiler.umd.min.js',
            '@angular/platform-browser': 'https://unpkg.com/@angular/platform-browser@2.4.1/bundles/platform-browser.umd.js',
            '@angular/platform-browser-dynamic': 'https://unpkg.com/@angular/platform-browser-dynamic@2.4.1/bundles/platform-browser-dynamic.umd.js',
            '@angular/http': 'https://unpkg.com/@angular/http@2.4.1/bundles/http.umd.js',
            '@angular/router': 'https://unpkg.com/@angular/router@3.2.0/bundles/router.umd.js',
            '@angular/forms': 'https://unpkg.com/@angular/forms@2.4.1/bundles/forms.umd.js',
            '@angular/upgrade': 'https://unpkg.com/@angular/upgrade@2.4.1/bundles/upgrade.umd.js',
            // other libraries
            'rxjs':                      'https://unpkg.com/rxjs@5.0.3'
        },
        // packages tells the System loader how to load when no filename and/or no extension
        packages: {
            app: {
                // the main script to be loaded from target/scala-2.11
                main: '../../../assets/ngclient-sjsx.js',
                map: {
                    // the name of the Scala.js module to be loaded
                    scalaModule: '../../../assets/ngclient-fastopt.js'
                },
                format: 'cjs',
                defaultExtension: 'js'
            },
            rxjs: {
                defaultExtension: 'js'
            }
        }
    });
})(this);