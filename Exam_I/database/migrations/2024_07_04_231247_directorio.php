<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class Directorio extends Migration
{
    public function up()
    {
        Schema::create('directorio', function (Blueprint $table) {
            $table->id('codigoEntrada');
            $table->string('nombre');
            $table->string('apellido');
            $table->string('correo');
            $table->string('telefono');
        });
    }


    public function down()
    {
        Schema::dropIfExists('directorio');
    }
}
