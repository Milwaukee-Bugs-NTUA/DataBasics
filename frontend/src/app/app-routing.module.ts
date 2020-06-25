import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './../app/components/home/home.component';
import { StoresComponent } from './../app/components/stores/stores.component';
import { StorepageComponent } from './../app/components/storepage/storepage.component';
import { AboutComponent } from './../app/components/about/about.component';
import { UsersComponent } from './../app/components/users/users.component';
import { ProductsComponent } from './../app/components/products/products.component';
import { ProductComponent} from './../app/components/product/product.component';
import { StatisticsComponent } from './../app/components/statistics/statistics.component';
import { ProductsstatisticsComponent } from './../app/components/productsstatistics/productsstatistics.component';
import { UsersstatisticsComponent } from './../app/components/usersstatistics/usersstatistics.component'; 
import { UserComponent } from './../app/components/user/user.component';
import { TransactionsComponent } from './../app/components/transactions/transactions.component';
import { TransactionComponent } from './../app/components/transaction/transaction.component';

const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'stores', component: StoresComponent },
    { path: 'users', component: UsersComponent },
    { path: 'products', component: ProductsComponent},
    { path: 'about', component: AboutComponent },
    { path: 'statistics', component: StatisticsComponent },
    { path: 'stores/storepage/:storeId', component: StorepageComponent },
    { path: 'products/product/:barcode', component: ProductComponent },
    { path: 'users/profile/:cardNumber', component: UserComponent },
    { path: 'stores/storepage/:storeId/transactions', component: TransactionsComponent },
    { path: 'transaction/:date/:time/:cardNumber', component: TransactionComponent },
    { path: 'statistics/productsStatistics', component: ProductsstatisticsComponent },
    { path: 'statistics/usersStatistics', component: UsersstatisticsComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
