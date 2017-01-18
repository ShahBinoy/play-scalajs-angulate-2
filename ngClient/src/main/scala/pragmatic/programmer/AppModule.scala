package com.washingtonpost.identity.csr.web

import angulate2.forms.FormsModule
import angulate2.http.HttpModule
import angulate2.platformBrowser.BrowserModule
import angulate2.std._

@NgModule(
  imports = @@[BrowserModule,FormsModule,HttpModule],
  declarations = @@[MainComponent,OtherComponent],
  bootstrap = @@[MainComponent,OtherComponent],
  providers = @@[CurrentUser]
)
class AppModule {

}
