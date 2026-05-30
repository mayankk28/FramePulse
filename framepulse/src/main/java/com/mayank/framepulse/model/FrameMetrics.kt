package com.mayank.framepulse.model

/**
 * Immutable snapshot of aggregated rendering metrics for a reporting window.
 *
 * Responsibilities:
 * - Carry read-only metrics from the metrics layer to [com.mayank.framepulse.api.FramePulseListener].
 * - Use stable, documented field semantics so hosts can log, assert, or display values safely.
 *
 * Must not:
 * - Contain behavior, mutable state, or references to Android UI components.
 *
 * Future role:
 * - Public data contract for v0.1; may gain jank-specific fields (e.g. jank count, percentiles)
 *   as the pipeline matures while preserving backward-compatible defaults.
 */
data class FrameMetrics(
    val elapsedRealtimeMs: Long,
    val fps: Double,
    val frameCount: Int,
    val averageFrameTimeMs: Double,
    val maxFrameTimeMs: Double,
)
