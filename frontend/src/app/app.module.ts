import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatTabsModule } from '@angular/material/tabs'; 
import { MatTableModule } from '@angular/material/table';
import { MatListModule } from '@angular/material/list';
import { MatChipsModule } from '@angular/material/chips';
import { MatDialogModule } from '@angular/material/dialog';
import { ChartsModule } from 'ng2-charts';

import { StoresComponent } from './components/stores/stores.component';
import { StorepageComponent } from './components/storepage/storepage.component';
import { UsersComponent } from './components/users/users.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductComponent } from './components/product/product.component';
import { UserComponent } from './components/user/user.component';
import { StatisticsComponent } from './components/statistics/statistics.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { ProductsstatisticsComponent } from './components/productsstatistics/productsstatistics.component';
import { UsersstatisticsComponent } from './components/usersstatistics/usersstatistics.component';
import { TransactionComponent } from './components/transaction/transaction.component';
import { UserInfoComponent } from './components/user-info/user-info.component';
import { PriceHistoryComponent } from './components/price-history/price-history.component';
import { InsertStoreComponent } from './components/insert-store/insert-store.component';
import { InsertUserComponent } from './components/insert-user/insert-user.component';
import { InsertProductComponent } from './components/insert-product/insert-product.component';
import { DeleteProductComponent } from './components/delete-product/delete-product.component';
import { DeleteUserComponent } from './components/delete-user/delete-user.component';
import { DeleteStoreComponent } from './components/delete-store/delete-store.component';
import { UpdateUserComponent } from './components/update-user/update-user.component';
import { UpdateStoreComponent } from './components/update-store/update-store.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { UpdateProductPriceComponent } from './components/update-product-price/update-product-price.component';

@NgModule({
  declarations: [AppComponent, HomeComponent, AboutComponent, StoresComponent, UsersComponent, ProductsComponent, StorepageComponent, ProductComponent,UserComponent, StatisticsComponent, TransactionsComponent, ProductsstatisticsComponent, UsersstatisticsComponent, TransactionComponent, UserInfoComponent, PriceHistoryComponent, InsertStoreComponent, InsertUserComponent, InsertProductComponent, DeleteProductComponent, DeleteUserComponent, DeleteStoreComponent, UpdateUserComponent, UpdateStoreComponent, UpdateProductComponent, UpdateProductPriceComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatInputModule,
    MatNativeDateModule,
    FormsModule, 
    ReactiveFormsModule,
    MatIconModule,
    MatButtonModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatGridListModule,
    MatTabsModule,
    MatTableModule,
    MatListModule,
    MatChipsModule,
    MatDialogModule,
    ChartsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
