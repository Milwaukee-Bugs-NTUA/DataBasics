import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './../app/components/home/home.component';
import { StoresComponent } from './../app/components/stores/stores.component';
import { StorepageComponent } from './../app/components/storepage/storepage.component';
import { AboutComponent } from './../app/components/about/about.component';
import { UsersComponent } from './../app/components/users/users.component';
import { ProductsComponent } from './../app/components/products/products.component';

const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'stores', component: StoresComponent },
    { path: 'users', component: UsersComponent },
    { path: 'products', component: ProductsComponent},
    { path: 'about', component: AboutComponent },
    { path: 'stores', component: StoresComponent },
    { path: 'stores/storepage/:storeId', component: StorepageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
