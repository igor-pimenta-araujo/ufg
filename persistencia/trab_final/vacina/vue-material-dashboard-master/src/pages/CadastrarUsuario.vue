<template>
  <div class="content">
    <div class="md-layout">
      <div class="md-layout-item md-medium-size-100 md-size-100">
        <usuario-form data-background-color="green"> </usuario-form>
      </div>
    </div>
  </div>
</template>

<script>
import { UsuarioForm } from "@/pages";

export default {
  components: {
    UsuarioForm,
  },
};
</script>
