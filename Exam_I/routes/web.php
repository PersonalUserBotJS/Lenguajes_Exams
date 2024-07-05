<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\directorioController;
use App\Http\Controllers\contactosController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('/directorio', [directorioController::class, 'mostrarDirectorio'])->name('directorio');
Route::get('/nuevaEntrada', [directorioController::class, 'nuevaEntrada'])->name('nuevaEntrada');
Route::get('/buscarEntrada', [directorioController::class, 'buscarEntrada'])->name('buscarEntrada');
Route::get('/eliminarEntrada',[directorioController::class, 'eliminarEntrada'])->name('eliminarEntrada');
Route::post('/nuevaEntrada/crear', [directorioController::class, 'agregarEntrada'])->name('agregarEntrada');


Route::get('/verContactos',[contactosController::class, 'verContactos'])->name('verContactos');
Route::get('/agregarContacto',[contactosController::class, 'agregarContacto'])->name('nuevoContacto');
Route::post('/agregarContacto/crear',[contactosController::class, 'crearContacto'])->name('crearContacto');
