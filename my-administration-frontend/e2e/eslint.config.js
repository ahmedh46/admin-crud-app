const baseConfig = require('../eslint.base.config.js');
const cypress = require('eslint-plugin-cypress/flat');

module.exports = [
  ...baseConfig,
  cypress.configs['recommended'],
  {
    // Override or add rules here
    rules: {},
  },
];
