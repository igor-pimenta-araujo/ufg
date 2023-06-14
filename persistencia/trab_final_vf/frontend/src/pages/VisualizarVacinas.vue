<template>
  <div class="content">
    <div class="md-layout">
      <div
        class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-100"
      >
        <md-card>
          <md-card-header data-background-color="green">
            <h4 class="title">Visualizar Vacinas</h4>
          </md-card-header>
          <md-card-content>
            <vacinas-table :items="this.item"></vacinas-table>
          </md-card-content>
        </md-card>
      </div>
    </div>
  </div>
</template>

<script>
import VacinasTable from "../components/Tables/VacinasTable.vue";
export default {
  components: { VacinasTable },
};
</script>
