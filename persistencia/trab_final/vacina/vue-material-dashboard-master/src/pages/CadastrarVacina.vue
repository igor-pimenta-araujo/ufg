<template>
  <div class="content">
    <div class="md-layout">
      <div class="md-layout-item md-medium-size-100 md-size-100">
        <vacina-form data-background-color="green"> </vacina-form>
      </div>
    </div>
  </div>
</template>

<script>
import { VacinaForm } from "@/pages";

export default {
  components: {
    VacinaForm,
  },
};
</script>
